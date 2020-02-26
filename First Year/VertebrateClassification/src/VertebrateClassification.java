import javax.swing.JOptionPane;

public class VertebrateClassification {

	public static void main(String[] args) {
		
		int blood = JOptionPane.showConfirmDialog (null, "Is the vertebrate cold blooded?");
		boolean coldBlooded = (blood == JOptionPane.YES_OPTION);
		
		String vertebrateClassification = "";
		if (coldBlooded)
		{
			int covering = JOptionPane.showConfirmDialog(null, "Does the vertebrate have moist skin?");
			boolean moistSkin = (covering == JOptionPane.YES_OPTION);
			if (moistSkin)
			{
				vertebrateClassification = "n amphibian"; 
			}
			else 
			{ 
				int fins = JOptionPane.showConfirmDialog(null, "Does the vertebrate have fins?");
				boolean yesFins = (fins == JOptionPane.YES_OPTION);	
				if (yesFins)
				{ 
					vertebrateClassification = "fish";
				}
				else 
				{ 
					vertebrateClassification = "reptile";
				}		
			}
		}
		else 
		{ int covering2 = JOptionPane.showConfirmDialog(null, "Does the vertebrate have feathers?");
		  boolean feathers = (covering2 ==JOptionPane.YES_OPTION);
		  if (feathers) 
		  {
			  vertebrateClassification = "bird";
		  }
		  else 
		  { 
			  vertebrateClassification = "mammal";
		  }
		}
		
		JOptionPane.showMessageDialog(null, "The vertebrate is a" + vertebrateClassification);
		// TODO Auto-generated method stub

	}

}
