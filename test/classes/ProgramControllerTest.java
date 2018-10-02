package classes;

import org.junit.Test;

public class ProgramControllerTest {

    @Test
    public void helpText() throws Exception {
        ProgramController.main(new String[] {"-h"});
    }
}
