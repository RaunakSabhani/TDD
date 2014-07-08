import java.util.EnumMap;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileType;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.client.constant.LanguageCodes;
import com.google.code.linkedinapi.client.constant.RelationshipCodes;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.sun.xml.xsom.impl.scd.Iterators.Map;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.Facets;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;

public class Connecting {
	public static void main(String[] args)
	{
	String str="GS LAB";
	String url="http://www.linkedin.com/pub/parag-dakle/72/bb9/555";
	final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance("75gz5qhdwkysly", "iZciwvebqPazvhhd");
	final LinkedInApiClient client = factory.createLinkedInApiClient("10bccaf5-eb08-4832-8c78-b76261de3aab", "bb7e04f9-c7a0-4865-95ad-244b51e43952");
	Person profile = client.getProfileByUrl(url, ProfileType.STANDARD);
	
	System.out.println("Name:" + profile.getFirstName() + " " + profile.getLastName());
	System.out.println("Headline:" + profile.getHeadline());
	System.out.println("Summary:" + profile.getSummary());
	System.out.println("Industry:" + profile.getIndustry());
	System.out.println("Picture:" + profile.getPictureUrl());
	Connections connections = client.getConnectionsForCurrentUser();
	System.out.println("Total connections fetched:" + connections.getTotal());
	for (Person person : connections.getPersonList()) {
		   boolean b=person.getHeadline().toLowerCase().contains(str.toLowerCase());
		   if(b==true)
	        System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
	}
	 }
}
