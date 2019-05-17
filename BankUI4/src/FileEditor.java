import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileEditor {
	RandomAccessFile file;

	public FileEditor(File fileName) throws IOException {
		// TODO Auto-generated constructor stub
		file = new RandomAccessFile(fileName, "rw");
	}

	public void closeFile() throws IOException {
		if (file != null)
			file.close();
	}

	public RandomAccessAccountRecord getRecord(int accountNumber)
			throws IllegalArgumentException, NumberFormatException, IOException {
		RandomAccessAccountRecord record = new RandomAccessAccountRecord();
		if (accountNumber < 1 || accountNumber > 100)
			throw new IllegalArgumentException("Out of range");
		file.seek((accountNumber - 1) * RandomAccessAccountRecord.SIZE);
		record.read(file);
		return record;
	}

	public void updateRecord(int accountNumber, String firstName, String lastName, double balance)
			throws IllegalArgumentException, IOException {
		RandomAccessAccountRecord record = getRecord(accountNumber);
		if (record.getAccount() == 0)
			throw new IllegalArgumentException("Account does not exist");
		file.seek((accountNumber - 1) * RandomAccessAccountRecord.SIZE);
		record = new RandomAccessAccountRecord(accountNumber, firstName, lastName, balance);
		record.write(file);
	}

	public void newRecord(int accountNumber, String firstName, String lastName, double balance)
			throws IllegalArgumentException, IOException {
		RandomAccessAccountRecord record = getRecord(accountNumber);
		if (record.getAccount() != 0)
			throw new IllegalArgumentException("Account already exist");
		file.seek((accountNumber - 1) * RandomAccessAccountRecord.SIZE);
		record = new RandomAccessAccountRecord(accountNumber, firstName, lastName, balance);
		record.write(file);
	}

	public void deleteRecord(int accountNumber) throws IllegalArgumentException, IOException {
		RandomAccessAccountRecord record = getRecord(accountNumber);
		if (record.getAccount() == 0)
			throw new IllegalArgumentException("Account does not exist");
		file.seek((accountNumber - 1) * RandomAccessAccountRecord.SIZE);
		record = new RandomAccessAccountRecord();
		record.write(file);
	}
}
