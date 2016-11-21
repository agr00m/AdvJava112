package java112.employee;

import java.io.*;
import java.util.*;

/**  
 *  
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-10-2016 <br>
 *
 *  @author Aaron Groom
 *  @since  4.0
 */

public class Search {
    
    private String searchType = "";
    private String searchTerm = "";
    private List<String> searchResults = null;
    private Boolean foundEmployees = false;

   
    /**

	 * Constructor.
	 */

    public Search() {
        
    }
    
    public void addFoundEmployee(Employee employee) {
        
    }
    
	/**

	 * Returns the value of searchType.

	 */

	public String getSearchType() {

		return searchType;

	}



	/**

	 * Sets the value of searchType.

	 * @param searchType The value to assign searchType.

	 */

	public void setSearchType(String searchType) {

		this.searchType = searchType;

	}



	/**

	 * Returns the value of searchTerm.

	 */

	public String getSearchTerm() {

		return searchTerm;

	}



	/**

	 * Sets the value of searchTerm.

	 * @param searchTerm The value to assign searchTerm.

	 */

	public void setSearchTerm(String searchTerm) {

		this.searchTerm = searchTerm;

	}



	/**

	 * Returns the value of searchResults.

	 */

	public List<String> getSearchResults() {

		return searchResults;

	}



	/**

	 * Sets the value of searchResults.

	 * @param searchResults The value to assign searchResults.

	 */

	public void setSearchResults(List<String> searchResults) {

		this.searchResults = searchResults;

	}



	/**

	 * Returns the value of foundEmployees.

	 */

	public Boolean getFoundEmployees() {

		return foundEmployees;

	}



	/**

	 * Sets the value of foundEmployees.

	 * @param foundEmployees The value to assign foundEmployees.

	 */

	public void setFoundEmployees(Boolean foundEmployees) {

		this.foundEmployees = foundEmployees;

	}

}