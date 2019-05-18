import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	private FileChannel fileChannel;

	public FileChannelTest() {
		try {
			RandomAccessFile file = new RandomAccessFile("Test", "rw");
			fileChannel = file.getChannel();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void writeToFile() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(14);
		buffer.putInt(100);
		buffer.putChar('A');
		buffer.putDouble(12.34);
		buffer.flip();
		fileChannel.write(buffer);
	}

	public void readFromFile() throws IOException {
		// TODO Auto-generated method stub
		String content = "";
		ByteBuffer buffer = ByteBuffer.allocate(14);
		fileChannel.position(0);
		fileChannel.read(buffer);
		buffer.flip();
		content = buffer.getInt() + ", " + buffer.getChar() + ", " + buffer.getDouble();
		System.out.println("File contains: " + content);
		fileChannel.close();
	}

	public static void main(String[] args) {
		FileChannelTest fileChannelTest = new FileChannelTest();
		try {
			fileChannelTest.writeToFile();
			fileChannelTest.readFromFile();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
