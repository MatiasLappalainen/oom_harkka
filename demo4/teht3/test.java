class Olio {

}

class test {
    public static void main(String[] args)  {
        new test();
    }

    {

        Olio[] oliot = new Olio[]{new Olio()};
        oliot[0] = new Olio();

        Object[] objectit = oliot;
        objectit[0] = new Olio();
        objectit[0] = new Object();

        System.out.println(objectit[0] instanceof Object);
    }}
