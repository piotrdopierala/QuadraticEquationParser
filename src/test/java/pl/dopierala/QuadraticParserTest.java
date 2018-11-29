package pl.dopierala;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticParserTest {

    @Test
    public void shouldParseToA10B20C30()
    {
        //given
        String toParse = "10x^2+20x+30=0";
        QuadraticEquation shouldGet = new QuadraticEquation(10, 20, 30);
        //when
        QuadraticEquation result = QuadraticEquationParser.parse(toParse);
        //then
        Assert.assertEquals(shouldGet,result);
    }

    @Test
    public void shouldParseToA10B0C0()
    {
        //given
        String toParse = "10x^2=0";
        QuadraticEquation shouldGet = new QuadraticEquation(10, 0, 0);
        //when
        QuadraticEquation result = QuadraticEquationParser.parse(toParse);
        //then
        Assert.assertEquals(shouldGet,result);
    }

    @Test
    public void shouldParseToA1B0C1()
    {
        //given
        String toParse = "x^2+1=0";
        QuadraticEquation shouldGet = new QuadraticEquation(1, 0, 1);
        //when
        QuadraticEquation result = QuadraticEquationParser.parse(toParse);
        //then
        Assert.assertEquals(shouldGet,result);
    }

    @Test
    public void shouldParseToA10B0C20Joining()
    {
        //given
        String toParse = "5x^2+4x^2+x^2+15+5+0=0";
        QuadraticEquation shouldGet = new QuadraticEquation(10, 0, 20);
        //when
        QuadraticEquation result = QuadraticEquationParser.parse(toParse);
        //then
        Assert.assertEquals(shouldGet,result);
    }

    @Test
    public void shouldParseToA10B0C20JoiningMinus()
    {
        //given
        String toParse = "5x^2+6x^2-x^2+15+6-1=0";
        QuadraticEquation shouldGet = new QuadraticEquation(10, 0, 20);
        //when
        QuadraticEquation result = QuadraticEquationParser.parse(toParse);
        //then
        Assert.assertEquals(shouldGet,result);
    }
}
