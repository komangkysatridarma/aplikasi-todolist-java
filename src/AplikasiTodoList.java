public class AplikasiTodoList {
        public static String[] model = new String[10];

        public static java.util.Scanner scanner = new java.util.Scanner(System.in);

        public static void main(String[] args) {
        viewTodoList();

        }

        public static void addTodoList(String todo){

            var isFull = true;
            for(int i = 0; i < model.length; i++){
                if(model[i] == null){
                    //model masih ada yang kosong
                    isFull = false;
                    break;
                }
            }

            if(isFull){
                var temp = model;
                model = new String[model.length * 2];

                for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
                }
            }

            //tambahkan ke posisi yang data array nya null
            for(var i = 0; i < model.length; i++){
                if(model[i] == null){
                    model[i] = todo;
                    break;
                }
            }
        }

        public static void testAddTodoList(){
            for (int i = 0; i < 20; i++) {
                addTodoList("Contoh Todo ke-" + i);
            }

            showTodoList();
        }

        public static boolean deleteTodoList(Integer number){
            if((number - 1) >= model.length){
                return false;
            }
            else if(model[number - 1] == null){
                return false;
            }else{
                for (int i = (number - 1); i < model.length; i++) {
                    if(i == (model.length - 1)){
                        model[i] = null;
                    }else {
                        model[i] = model[i + 1];
                    }
                }
                return true;
            }
        }

        public static void testDeleteTodoList(){
            addTodoList("Satu");
            addTodoList("Dua");
            addTodoList("Tiga");
            addTodoList("Empat");
            addTodoList("Lima");

            var result = deleteTodoList(20);
            System.out.println(result);

            result = deleteTodoList(6);
            System.out.println(result);

            result = deleteTodoList(2);
            System.out.println(result);

            showTodoList();

        }

        public static void showTodoList(){
            for(var i = 0; i < model.length; i++){
                var todo = model[i];
                var no = i + 1;

                if(todo != null){
                    System.out.println(no + ". " + todo);
                }
            }
        }

        public static void testShowTodoList(){
            model[0] = "Belajar java dasar";
            model[1] = "Mengerjakan Studi kasus TodoList";
            model[2] = "Tidur";

            showTodoList();
        }

        public static String input(String info){
            System.out.print(info + " : ");
            String data = scanner.nextLine();
            return data;
        }

        public static void testInput(){
            var data = input("Nama");
            System.out.println("Hi " + data);

            var channel = input("Channel");
            System.out.println(channel);
        }

        public static void viewTodoList(){
            while(true){
                System.out.println("Todo List: ");
                showTodoList();

                System.out.println("Menu: ");
                System.out.println("1. Tambah");
                System.out.println("2. Hapus");
                System.out.println("x. Keluar");

                var input = input("Pilih");
                if(input.equals("1")){
                    viewCreateTodoList();
                }else if (input.equals("2")){
                    viewDeleteTodoList();
                }else if(input.equals("x")){
                    break;
                }
                else{
                    System.out.println("Pilihan tidak dimengerti");
                }

            }
        }
        public static void testViewShowTodoList(){
            addTodoList("Satu");
            addTodoList("Dua");
            addTodoList("Tiga");
            addTodoList("Empat");
            addTodoList("Lima");
            viewTodoList();
        }

        public static void viewCreateTodoList(){
            System.out.println("Menambah Todo List");

            var todo = input("Todo (x jika batal)");

            if(todo.equals("x")){
                //batal
            }else {
                addTodoList(todo);
            }
        }

        public static void testViewAddTodoList(){
            addTodoList("Satu");
            addTodoList("Dua");
            addTodoList("Tiga");

            viewCreateTodoList();

            showTodoList();
        }

        public static void viewDeleteTodoList(){
            System.out.println("Menghapus Todo List");

            var number = input("Nomor yang dihapus (x jika batal)");

            if(number.equals("x")){
                //batal
            }else{
                //merubah yang tadinya variabel number string, menjadi integer
                boolean success =  deleteTodoList(Integer.valueOf(number));
                if(!success){
                    System.out.println("gagal menghapus todolist : " + number);
                }
            }
        }

        public static void testViewDeleteTodoList(){
            addTodoList("Satu");
            addTodoList("Dua");
            addTodoList("Tiga");

            showTodoList();

            viewDeleteTodoList();

            showTodoList();

        }
    }
