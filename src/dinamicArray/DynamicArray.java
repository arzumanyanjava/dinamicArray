package dinamicArray;

public class DynamicArray {
    // սա մեր հիմնական մասիվն է որտեղ ավելացնելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    private int size = 0;


    // ստուգել եթե մասիվի մեջ տեղ չկա ավելացնել extend() և ավելացնենք
    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    // ստեղծել հին մասիվից 10 էլեմենտ ավելի մասիվ
    // քցել հին մասիվի էլեմենտները նորի մեջ
    // հին մասիվի հղումը կապենք նորի հետ
    private void extend() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    // եթե տրված ինդեքսը մեր ունեցած մասիվի սահմաններում է վերադարձնել մասիվի ինդեքս երորդ էլեմենտը
    public int getByIndex(int index) {
        return index >= 0 && index < size ? array[index] : -1;
    }

    // տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // վերադարձնել ավելացված թվերի ամենամեծը
    public int max() {
        int max = array[0];
        for (int i = 0; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;

    }
    // վերադարձնել ավելացված թվերի ամենափոքրը
    public int min(){
        int min = array[0];
        for (int i = 0; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    // մասիվից ջնջում ենք եկած ինդեքսի տակ ընկած էլեմենտը, հետո տպելուց կտպի մասիվի էլեմենտները իրար կողք, իսկ ջնջվածը ոչ
    public void deleteByIndex(int index){
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
    }
    // մասիվից ջնջում ենք տրված value-ին հավասար բոլոր էլեմենտները
    public void deleteByValue(int value){
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteByIndex(i);
            }
        }
    }
    // մասիվից ջնջում ենք տրված value-ին հավասար միայն առաջին էլեմենտը
    public void deleteByValueFirst(int value){
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteByIndex(i);
                break;
            }
        }
    }
    // մասիվից կկտրի ու կստանա նոր փոքր մասիվ
    public int[] subArray(int startIndex, int endIndex){
        if (startIndex < 0 || endIndex > size || startIndex >= endIndex) {
            System.out.println("սխալ ինդեքսներ");
            return null;
        }
        int[] result = new int[endIndex - startIndex];
        int index = 0;
        for (int i = startIndex; i < endIndex; i++) {
            result[index++] = array[i];
        }
        return result;
    }
    // մասիվից կկտրի ու կստանա նոր փոքր մասիվ ըստ startIndex- ի ու մինչև վերջ
    public int[] subArray(int startIndex){
        if (startIndex < 0 || startIndex >= size) {
            System.out.println("սխալ ինդեքս");
            return null;
        }
        int[] result = new int[size - startIndex];
        int index = 0;
        for (int i = startIndex; i < size; i++) {
            result[index++] = array[i];
        }
        return result;
    }
}


