import com.lesfurets.jenkins.unit.declarative.DeclarativePipelineTest;
import org.junit.jupiter.api.Test;

public class DeclarativePipelineJobTest extends DeclarativePipelineTest {
    @Test
    void testDeclarativePipeline() {
        runScript("testJob2.jenkins");
        assertJobStatusSuccess();
        printCallStack();
    }
}
