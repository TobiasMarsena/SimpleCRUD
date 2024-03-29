package simpleCRUD.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "myfiles")
public class MyFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "filename")
	private String filename;
	
	@Lob
	@Column(name = "data")
	private byte[] data;
	
	public MyFile() {}
	public MyFile(String filename, byte[] data) {
		super();
		this.filename = filename;
		this.data = data;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "MyFile [id=" + id + ", filename=" + filename + ", data=" + Arrays.toString(data) + "]";
	}
	
}
