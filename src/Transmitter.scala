import java.net.Socket
import java.net.InetSocketAddress
import java.net.SocketAddress
import java.nio.channels.DatagramChannel
import java.nio.channels.ServerSocketChannel

/** TODO:
  * - exception handling
  * - entity change
  */

object Transmitter {
	private val PORT = 4226
	private val BUFSIZE = 2048//note this

	private val socket = new DatagramSocket(PORT);
	private val addresses = new LinkedList(InetAddress.getByName("localhost"), null)//dummy header

	private def intArrayToByteArray(a : Array[Int]) : Array[Byte] {//be careful with neg integers
		val b = Array[Byte](a.size*4)
		var i = 0
		for (i <- 0 until a.size) {
			b(4*i)   = (a(i) >> 24)&0xFF
			b(4*i+1) = (a(i) >> 16)&0xFF
			b(4*i+2) = (a(i) >> 8 )&0xFF
			b(4*i+3) = (a(i) >> 8 )&0xFF
		}
		b
	}
	
	def connect(address : String) = {
		addresses.next = LinkedList(InetAddress.getByName(address), addresses.next)
	}

	def terrainChange(changes : Array[(Position, Material)]) = {
		var recipient = addresses
		while (recipient.next != null) {//traverse linked list
			//ensure buffer can be large enough
			assert(changes.size*4*4 < BUFSIZE)

			//build buffer
			val preBuf = Array[Int].fill(BUFSIZE/4)(Int.MaxValue)//fill empty space with max int
			preBuf(0) = 0//code for terrainChange
			var i = 1
			for (i <- 1 to changes.size) {
				preBuf(i*4)   = changes(i)._1.x
				preBuf(i*4+1) = changes(i)._1.y
				preBuf(i*4+2) = changes(i)._1.z
				preBuf(i*4+3) = changes(i)._2.id
			}
			val buf = intArrayToByteArray(preBuf)
			
			//packing and postage
			val packet = new DatagramPacket(buf, buf.size, recipient.next.elem, PORT);
			socket.send(packet)
		}
	}

	def entityChange(Array[Entity]) = ??? 
}
