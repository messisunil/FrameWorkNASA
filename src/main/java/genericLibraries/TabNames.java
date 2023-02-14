package genericLibraries;

public enum TabNames {
	ORGANIZATIONS("Organizations"),CONTACTS("Contacts"),LEADS("Leads");
	private String tabName;
	TabNames(String tab) {
		this.tabName = tab;
	}
	
	public String getTabName()
	{
		return tabName;
	}
}
