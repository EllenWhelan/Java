
public class TableEntry {
	public String destination;
	public String localSrc;
	public String localDst;
	public String router;

	TableEntry() {
		destination = null;
		localSrc = null;
		localDst = null;

	}
	
	public TableEntry(String router, String dest, String localSrc, String localDst){
		this.destination=dest;
		this.localDst=localDst;
		this.localSrc=localSrc;
		this.router=router;
	}

	
}
