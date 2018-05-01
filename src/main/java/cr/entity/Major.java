package cr.entity;

public class Major {
	    private String name;
	    private String code;
	    private String option;
	    private int id;
	    
	    public Major()
	    {
	    	
	    }
	    
	    public Major (String name, String code, String option, int id)
		{
			this.name= name;
			this.code = code;
			this.option = option;
			this.id = id;
		}
	    
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getOption() {
			return option;
		}

		public void setOption(String option) {
			this.option = option;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "majorName: " + name + ", majorCode: " + code + ", majorOption: " + option
					+ ", majorID: " + id;
		}
		
}
