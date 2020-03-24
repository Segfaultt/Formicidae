import scala.collection.mutable.LinkedList
import java.net.Socket
import java.net.InetSocketAddress
import java.net.InetAddress
import java.net.SocketAddress
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.nio.channels.DatagramChannel
import java.nio.channels.ServerSocketChannel

/** TODO:
  * - exception handling
  * - entity change
  */

/** packet prefix codes
  * code(Int32)	| meaning
  * ----------------------
  * 	0	| new connection
  *	1	| terrain change
  */

object Transmitter {
	private var port = 0
	private val BUFSIZE = 2048//note this and make sure its the same as Receiver.scala

	private var socket : DatagramSocket = null;
	private val addresses = new LinkedList(InetAddress.getByName("localhost"), null)//dummy header

	//send buf to recipient
	private def sendBuf(buf : Array[Byte], recipient : InetAddress) : Unit = 
	{
		val packet = new DatagramPacket(buf, buf.size, recipient, port);
		socket.send(packet)
	}

	//send buf to every address in addresses
	private def broadcast(buf : Array[Byte]) : Unit =
	{
		var recipient = addresses
		while (recipient.next != null) { sendBuf(buf, recipient.next.elem) }	
	}
	
	private def intArrayToByteArray(a : Array[Int]) : Array[Byte] =//be careful with neg integers
	{
		val b = new Array[Byte](a.size*4)
		var i = 0
		for (i <- 0 until a.size) {
			b(4*i)   = (a(i) >> 24).toByte
			b(4*i+1) = (a(i) >> 16).toByte
			b(4*i+2) = (a(i) >> 8 ).toByte
			b(4*i+3) =  a(i).toByte
		}
		b
	}
	
	def getPort : Int = port

	def getSocket : DatagramSocket = socket

	def init (sendingPort : Int) : Unit = 
	{
		port = sendingPort
		socket = new DatagramSocket
	}

	def addConnection(address : String) : Unit = 
	{
		addresses.next = new LinkedList(InetAddress.getByName(address), addresses.next)
	}

	def connectToServer(address : String) : Unit = 
	{
		addConnection(address)
		val buf = Array.fill[Byte](BUFSIZE)(0)
		sendBuf(buf, InetAddress.getByName(address))
	}

	def terrainChange(changes : Array[(Position, Material)]) : Unit = 
	{
		//ensure buffer can be large enough
		assert(changes.size*4*4 < BUFSIZE)

		//build buffer
		val preBuf = Array.fill[Int](BUFSIZE/4)(Int.MaxValue)//fill empty space with max int
		preBuf(0) = 1//code for terrainChange
		var i = 1
		for (i <- 0 until changes.size) {
			preBuf(i*4+1) = changes(i)._1.x
			preBuf(i*4+2) = changes(i)._1.y
			preBuf(i*4+3) = changes(i)._1.z
			preBuf(i*4+4) = changes(i)._2.id
		}
		val buf = intArrayToByteArray(preBuf)
		
		broadcast(buf)
	}

	def close : Unit = {
		socket.close
	}
	
	def entityChange(changes : Array[Entity]) = ??? 
}
