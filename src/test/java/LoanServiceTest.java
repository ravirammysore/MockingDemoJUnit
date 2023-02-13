import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class LoanServiceTest {

    IUserService mockUserService;
    IPersonRepository mockPersonRepo;

    @BeforeEach
    void testInit(){
        mockUserService = mock(IUserService.class);
        mockPersonRepo = mock(IPersonRepository.class);
    }
    @Test
    void isEligibleForLoan_MustBeTrue() {
        //arrange
        when(mockUserService.IsUserValid(anyString()))
                .thenReturn(true);

        var person = new Person();
        person.setAge(18);
        person.setCreditScore(1200);

        when(mockPersonRepo.Get(anyString()))
                .thenReturn(person);

        var sut = new LoanService(mockUserService, mockPersonRepo);

        //act
        var result = sut.IsEligibleForLoan(anyString());

        //assert
        assertTrue(result);
    }
}