public class ModernArt{
        public static void main(String[] args)
                {
        		String NAME = "Matthew";
                int ROWS = 9;
                for(int i = 1; i <= ROWS*8; ++i){
                	System.out.print("#");
                }
                System.out.println();
                for(int i = 1; i <= ROWS; ++i){
                        for(int j = 1; j<= i; ++j){
                        System.out.print("* \t");
                        }
                        if(i==5){
                        System.out.print("This is "+NAME+"'s Modern Art");
                       }
                       System.out.println();
                }
                for(int i = 1; i <= ROWS*8; ++i){
                	System.out.print("#");
                }
                }
}
