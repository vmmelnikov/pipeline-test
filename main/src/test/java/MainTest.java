import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.vsu.amm.poiais.Calculator;
import ru.vsu.amm.poiais.Main;

@ExtendWith(MockitoExtension.class)
public class MainTest {
    
    // @Mock
    // private Calculator c;
    
    @Test
    public void testMainAdd() {
        // given
        Calculator c = mock();
        //when(c.add(anyDouble(), anyDouble())).thenReturn(1.0);
        doAnswer(invocation -> (Double)invocation.getArgument(0) + (Double)invocation.getArgument(1))
            .when(c).add(anyDouble(), anyDouble());
        // when
        Main main = new Main();
        double sum = main.add(c, 0.5, 0.5, 0.5);
        // then
        ArgumentCaptor<Double> arg = ArgumentCaptor.forClass(Double.class);

        verify(c, times(1)).add(eq(0.5), arg.capture());

        verify(c, times(2)).add(anyDouble(), arg.capture());

        assertThat(arg.getValue()).isEqualTo(0.5, within(0.01));
        assertThat(sum).isEqualTo(1.5, within(0.001));
    }
}
