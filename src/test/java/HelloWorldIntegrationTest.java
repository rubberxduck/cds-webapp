
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HelloWorldIntegrationTest {

    @Test
    public void test() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage("http://localhost/cds-webapp/index.html");
        Assert.assertEquals("Hello World - Title", page.getTitleText());

        final String pageAsXml = page.asXml();
        Assert.assertTrue(pageAsXml.contains("Hello World!"));

        final String pageAsText = page.asText();
        Assert.assertTrue(pageAsText.contains("Hello World!"));

        webClient.closeAllWindows();
    }

}
