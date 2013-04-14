package concretemanor.tools.teamview.stripes;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class SafeHtmlUtil
{
	public static String sanitize(String raw)
	{
		if (raw==null || raw.length()==0)
			return raw;

		return HTMLEntityEncode(canonicalize(raw));
	}


	private static Pattern pattern = Pattern.compile("script",Pattern.CASE_INSENSITIVE); //.replacer();

	public static String HTMLEntityEncode(String input)
	{
		String next = pattern.matcher(input).replaceAll("&#x73;cript");

		StringBuffer sb = new StringBuffer();
		for ( int i = 0; i < next.length(); ++i )
		{
			char ch = next.charAt( i );

			if (ch=='<')
				sb.append("&lt;");
			else if (ch=='>')
				sb.append("&gt;");
			else
				sb.append(ch);
		}

		return sb.toString();
	}


	// "Simplifies input to its simplest form to make encoding tricks more difficult"
	// though it didn't do seem to do anything to hex or html encoded characters... *shrug* maybe for unicode?
	public static String canonicalize( String input )
	{
		String canonical = Normalizer.normalize(input, Normalizer.Form.NFD);
		return canonical;
	}
}