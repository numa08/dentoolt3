package controllers

import org.apache.commons.daemon._
import play.core.server.NettyServer
import play.core.StaticApplication
import java.io.File

class ServerDaemon extends Daemon {
	var nettyServer:NettyServer = _
	var applicationPath : File = _

	override def init(context: DaemonContext){
		applicationPath = new File(context.getArguments()(0))
	}

	override def start{
		nettyServer = new NettyServer(
			new StaticApplication(applicationPath),
			Option(System.getProperty("http.port")).map(Integer.parseInt(_)).getOrElse(9080),
			Option(System.getProperty("http.address")).getOrElse("0.0.0.0")
			)
	}

	override def stop{
		if(nettyServer != null)nettyServer.stop
	}

	override def destroy{
		nettyServer = null
	}
}