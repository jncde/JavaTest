package covariantAndContravariant;


class Base{}
class Drived extends Base{}


//step1: defin interface and implement ContravariantParams
interface cparm{
  Base consum(Drived d);
}

class Concret implements cparm {

  @Override public Base consum (Drived d) {
      return null;
  }
}
//step2: change interface, more abstract parameter type and more specifical return type
//interface cparm{
//  Drived consum(Base d);
//}
//
//class Concret implements cparm {
//
//  @Override public Drived consum (Base d) {
//    return null;
//  }
//}


public class ContravariantParams {

//usae oc function must not be changed after step2
  public static void main (String[] args){
    cparm c = new Concret();
    Drived d = new Drived ();
    Base b=c.consum (d);
  }

}
