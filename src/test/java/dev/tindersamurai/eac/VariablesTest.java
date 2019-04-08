package dev.tindersamurai.eac;

import dev.tindersamurai.eac.comp.annotation.Arg;
import dev.tindersamurai.eac.comp.annotation.EscapyComponent;
import dev.tindersamurai.eac.comp.annotation.EscapyComponentFactory;
import dev.tindersamurai.eac.parser.EscapyComponentParser;
import dev.tindersamurai.eac.parser.XmlStreamComponentParser;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class VariablesTest {

	@EscapyComponentFactory("test")
	public static final class TestComponent {

		@EscapyComponent("var")
		public void var(
				@Arg("rooted_home") String home,
				@Arg("rooted_work") String work,
				@Arg("rooted_root") String root
		) {
			log.info("HOME: " + home);
			log.info("WORK: " + work);
			log.info("ROOT: " + root);
		}
	}

	@Test
	public void testRootedVariable() throws Exception {
		final EscapyComponentParser parser = new XmlStreamComponentParser(new TestComponent());
		parser.parseComponent(System.getProperty("user.dir") + "/src/test/resources/variables.xml");
	}
}