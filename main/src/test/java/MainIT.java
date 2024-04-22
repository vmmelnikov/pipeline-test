import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.vsu.amm.poiais.Calculator;
import ru.vsu.amm.poiais.Main;

@ExtendWith(MockitoExtension.class)
public class MainIT {
    
    @Mock
    Calculator c;
    
    @InjectMocks
    Main main = new Main();

    @Test
    public void testAddMethod() {
        // given
        when(c.add(anyDouble(), anyDouble())).thenReturn(4.0);
        // when
        double sum = main.add(1.0, 1.0, 1.0);
        // then 
        assertThat(sum).isEqualTo(4, within(0.001));
    }

    @Test
    public void testMainMethod() {
        // given
        
        // when
        Main.main(new String[]{"1.0", "1.0", "1.0"});
        // then 
    }

    
}
