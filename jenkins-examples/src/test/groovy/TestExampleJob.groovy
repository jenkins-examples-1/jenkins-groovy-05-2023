import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestExampleJob extends BasePipelineTest {
    @Override
    @BeforeEach
    void setUp() throws Exception {
        scriptExtension = "jenkins"
        scriptRoots << "src/main/groovy"
        baseScriptRoot = "src/main/groovy/job"
        addEnvVar('OS_VERSION', "Windows 10")
        addParam('ENABLE_LOGGING', 'false')
        super.setUp()
        helper.registerAllowedMethod('sh', [Map]) { args -> 'abcd123\n'}
        helper.registerAllowedMethod('echo',  [String], { String message ->
            println(message)
        })
    }

    @Test
    void testLoadScript() {
        loadScript('testJob1.jenkins').execute()
        printCallStack()
    }

    @Test
    void testParamsAndEnv() {
        Assertions.assertEquals("Windows 10", binding.getVariable('env')['OS_VERSION'])
        Assertions.assertEquals("false", binding.getVariable('params')['ENABLE_LOGGING'])
    }

    @Test
    void testFileExistsAndReadFile() {
        helper.addFileExistsMock('output', true)
        helper.addReadFileMock('output', 'FAILED!!!')
        helper.addShMock('mvn clean package', '', 0)
        runScript('testJob1.jenkins')

        assertJobStatusFailure()
    }
}
