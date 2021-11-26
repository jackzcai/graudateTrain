import static javax.swing.UIManager.get;
import java.util.UUID;

public class train2 {
    public static void main(String[] args){
        int a[]= {1,2};
        int b[]=a;
        Integer c=null;
        b[1]=999;
        for(int i=0;i<10;i++){
            int k=6;
        }
        char cd='a';

        System.out.println(cd+"h");
        System.out.println(a[0]+"\t"+a[1]);
        System.out.println(get(1));
        System.out.println("UuidSpecific.NIL : " + UuidSpecific.NIL.getUuid() );
    }
}



/**

 * @author Basil Bourque. Free forever to use at your own risk.

 */

 enum UuidSpecific {
    NIL( "00000000-0000-0000-0000-000000000000" ),

    TOLERABLE_UNIQUE_CONSTRAINT_VIOLATION( "e8e6528b-e43c-468b-b661-e24f1b64bee6" );

// Members

    private UUID uuid;

// Constructor

    UuidSpecific ( String uuidHexArg ) {
        this.uuid = java.util.UUID.fromString( uuidHexArg );

    }

// Getters

    UUID getUuid ( ) {
        return this.uuid;

    }

}
