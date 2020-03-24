import java.net.Socket
import java.net.InetSocketAddress
import java.net.InetAddress
import java.net.SocketAddress
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.nio.channels.DatagramChannel
import java.nio.channels.ServerSocketChannel

object Receiver {
	private var port = 0
	private val BUFSIZE = 2048//note this and make sure its the same as Transmitter.scala

	private var socket : DatagramSocket = null;

	def getPort : Int = port

	def getSocket : DatagramSocket = socket

	def init(sendingPort : Int) = 
	{
		port = sendingPort
		socket = new DatagramSocket(port)
	}
	
	def listenForNewClient : Unit = 
	{
		val buf = new Array[Byte](BUFSIZE)
		val packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet)
		
		var i = 0
		var data = packet.getData
		println("buf: ")
		for (i <- 0 until BUFSIZE) print(buf(i))
		println("data: ")
		for (i <- 0 until packet.getLength) print(data(i))
	}
	
	def listen : Unit =
	{
		
	}

	def close : Unit = {
		socket.close
	}
}
