package io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
/**
 * @说明 UDP连接客户端
 */
public class UdpClient {
	public static void main(String[] args) {
		try {
			for(int i=0;i<1;i++){
				new Thread(new ClientImpl()).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 * @说明 线程创建自己的UDP连接，端口动态，发送一组数据然后接收服务端返回
 * @author 崔素强（http://cuisuqiang.iteye.com/）
 * @version 1.0
 * @since
 */
class ClientImpl implements Runnable{
	private Random random = new Random();
	private String uuid = UUID.randomUUID().toString();
	public void run() {
		try {  
			init();
			byte[] buffer = new byte[1024 * 64]; // 缓冲区
			// 发送随机的数据
			byte[] btSend = new byte[]{(byte)random.nextInt(127), (byte)random.nextInt(127), (byte)random.nextInt(127)};
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(UdpService.host),UdpService.port);//2233
			packet.setData(btSend);
			System.out.println(uuid + "：发送：" + Arrays.toString(btSend));
			try {
				sendDate(packet);
			} catch(Exception e){
				e.printStackTrace();
			}
			receive(packet);
			byte[] bt = new byte[packet.getLength()];
			System.arraycopy(packet.getData(), 0, bt, 0, packet.getLength());
			if(null != bt && bt.length > 0){
				System.out.println(uuid + "：收到：" + Arrays.toString(bt));
			} 
			Thread.sleep(1 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 接收数据包，该方法会造成线程阻塞
	 * @return
	 * @throws IOException
	 */
 	public void receive(DatagramPacket packet) throws Exception {
		try {
			datagramSocket.receive(packet);
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 发送数据包到指定地点
	 * @param bt
	 * @throws IOException
	 */
	public void sendDate(DatagramPacket packet) {
		try {
			datagramSocket.send(packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 初始化客户端连接
	 * @throws SocketException
	 */
	public void init() throws SocketException{
		try {
			datagramSocket = new DatagramSocket(random.nextInt(9999));
			datagramSocket.setSoTimeout(10 * 1000);
			System.out.println("客户端启动成功");
		} catch (Exception e) {
			datagramSocket = null;
			System.out.println("客户端启动失败");
			e.printStackTrace();
		}
	}
	private DatagramSocket datagramSocket = null; // 连接对象
}
