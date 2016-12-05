package java112.employee;

import java.io.*;
import java.util.*;

/**  
 *  Manages all the search criteria and results. The search type and terms 
 *  are stored as well as any results found. If results are found, the 
 *  foundEmployees flag is set.
 *  <p>
 *  Advanced Java (Java 152-112) <br>
 *  Unit 4, Project 4 <br>
 *  Date: 11-10-2016 <br>
 *
 *  @author Aaron Groom
 *  @since  4.0
 */
public class Search extends java.lang.Object {
    
    private String searchType = "";
    private String searchTerm = "";
    private List<Employee> searchResults = null;
    private Boolean found = false;

    /**
	 * Constructor.
	 */
    public Search() {
        searchResults = new ArrayList<Employee>();
    }
    
    /**
	 * Adds an employee to the searchResults ArrayList.
	 * @param employee employee to add to found search results.
	 */
    public void addFoundEmployee(Employee employee) {
        searchResults.add(employee);
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
	public List<Employee> getSearchResults() {
		return searchResults;
	}

	/**
	 * Sets the value of searchResults.
	 * @param searchResults The value to assign searchResults.
	 */
	public void setSearchResults(List<Employee> searchResults) {
		this.searchResults = searchResults;
	}

	/**
	 * Returns the value of foundEmployees.
	 */
	public Boolean found() {
		return found;
	}

	/**
	 * Sets the value of foundEmployees.
	 * @param foundEmployees The value to assign foundEmployees.
	 */
	public void setFound(Boolean foundEmployees) {
		this.found = foundEmployees;
	}
}