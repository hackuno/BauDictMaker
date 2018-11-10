package hck.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import hck.enums.PreprocessorAdds;
import hck.services.Preprocessor;
import hck.utils.Utils;

@RunWith(JUnitPlatform.class)
class PreoprocessorTest {

	@BeforeAll
	public static void setup() {

	}

	@Test
	void preprocessor() {
		
		//TODO
		Utils.pl("ATTENTION: PREPROC TEST NEED TO BE WRITE CORRECTLY");
		Preprocessor preproc = new Preprocessor(PreprocessorAdds.NUMBERS1_31,PreprocessorAdds.NUMBERS0_9_DOUBLE,PreprocessorAdds.CURR_YEAR,PreprocessorAdds.PREV_YEAR, PreprocessorAdds.MONTH_SINGLE_ZERO, PreprocessorAdds.MONTH_TXT_3_EN, PreprocessorAdds.MONTH_TXT_3_IT,PreprocessorAdds.MONTH_DOUBLE_ZERO);
		Utils.pl(preproc.getExtraLists().toString());
		Utils.pl("ATTENTION: PREPROC TEST NEED TO BE WRITE CORRECTLY");
	}

}
