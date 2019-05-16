import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessAccountRecord extends AccountRecord {
	public static final int SIZE = 72;

	public RandomAccessAccountRecord() {
		// TODO Auto-generated constructor stub
		this(0, "", "", 0.0);
	}

	public RandomAccessAccountRecord(int account, String firstName, String lastName, double balance) {
		super(account, firstName, lastName, balance);
	}

	public void read(RandomAccessFile file) throws IOException {
		setAccount(file.readInt());
		setFirstName(readName(file));
		setLastName(readName(file));
		setBalance(file.readDouble());
	}

	protected String readName(RandomAccessFile file) throws IOException {
		// TODO Auto-generated method stub
		char name[] = new char[15], temp;
		for (int count = 0; count < name.length; count++) {
			temp = file.readChar();
			name[count] = temp;
		}
		return new String(name).replace('\0', ' ');
	}

	public void write(RandomAccessFile file) throws IOException {
		file.writeInt(getAccount());
		writeName(file, getFirstName());
		writeName(file, getLastName());
		file.writeDouble(getBalance());
	}

	private void writeName(RandomAccessFile file, String name) throws IOException {
		StringBuffer buffer = null;
		if (name != null)
			buffer = new StringBuffer(name);
		else
			buffer = new StringBuffer(15);
		buffer.setLength(15);
		file.writeChars(buffer.toString());
	}
}
