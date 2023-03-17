package myList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;

    //Step 01: Constructor tạo ra mảng có kích thước mặc định = 10;
    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    //Step 02: Constructor tạo ra mảng có kích thước định trước
    public MyList(int capacity) {
        this.elements = new Object[capacity];
    }

    //Step 03. Thêm phần tử vào vị trí index trong mảng
    void add(int index, E element) {
        //Kiểm tra tính hợp lệ của giá trị index truyền vào, thông báo lỗi nếu sai,
        if (index == 0) {
            add(element);
            return;
        }
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            //Mở rộng mảng dữ liệu hiện tại thành mảng mới, nếu cần thiết
            //Dùng biến "temp" để lưu trữ tạm thời, đồng thời gán dữ liệu vào phần từ thứ index của mảng
            //Duyệt mảng từ phần tử index + 1(do index đã gán dữ liệu rồi) và tiến hành hoán đổi biến "temp" với các vị trí kế tiếp
            //đồng thời tăng kích thước mảng thực tế 1 đơn vị
            ensureCapacity();
            Object temp = elements[index];
            elements[index] = element;
            for (int i = index+1; i < size + 1; i++) {
                Object tempNext = elements[i];
                elements[i] = temp;
                temp = tempNext;
            }
            size++;
        }
    }

    //Step 04. Xóa phần tử khỏi mảng
    E remove(int index) {
        //Kiểm tra tính hợp lệ của giá trị index truyền vào, thông báo lỗi nếu sai,
        //nếu index hợp lệ thì duyệt mảng từ vị trí index, dùng hoán đổi để dịch dữ liệu qua phải
        //giảm giá trị mảng thực tế 1 đơn vị
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Actual size: " + size);
        } else {
            Object deletedElements = elements[index];
            for (int i = index; i < size-1; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return (E) deletedElements;
        }
    }

    //Step 05. Trả ra kích thước của mảng
    int size() {
        return this.size;
    }

    //Step 06. Sao chép mảng hiện tại
    @Override
    public E clone() {
        Object cloneArray = Arrays.copyOf(this.elements, size);
        return (E) cloneArray;
    }

    //Step 07. Kiểm tra sự tồn tại phần tử của mảng true/false
    boolean contains(E o) {
        // Dựa theo kết quả của hàm indexOf để trả về true/false (có/không)
        return indexOf(o) > 0;
    }

    //Step 08. Tìm vị trí phần tử trong mảng
    int indexOf(E o) {
        // Kiểm tra dữ liệu kiểm tra, nếu là null => tìm dữ liệu là null và trả ra index,
        // nếu khác null thì tìm giá trị equals với nó và trả ra index,
        // nếu không tim thấy thì trả về -1 (index ngoài mảng)
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Step 09. Nối phần thử chỉ định vào cuối mảng
    boolean add(E o) {
        //Mở rộng mảng dữ liệu hiện tại thành mảng mới, nếu cần thiết
        //Gán dữ liệu vào phần từ cuối của mảng
        //đồng thời tăng kích thước mảng thực tế 1 đơn vị
        ensureCapacity();
        elements[size++] = o;
        return true;
    }


    //Step 10. Mở rộng mảng dữ liệu
    private void ensureCapacity() {
        if (size == elements.length) {
            //Nhân đôi kích thước mảng khai báo và copy dữ liệu sang mảng mới
            int newSize = elements.length * 2;
            this.elements = (Object[]) Arrays.copyOf(elements, newSize);
        }
    }

    //Step 11. Trả ra phần tử
    E get(int index) {
        //Kiểm tra tính hợp lệ của giá trị index truyền vào, thông báo lỗi nếu sai,
        // trả ra kết quả nếu giá trị hợp lệ
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Actual size: " + size);
        } else {
            return (E) elements[index];
        }
    }

    //Step 12. Xóa tất cả phần tử khỏi mảng = size = 0
    void clear() {
        //Đặt kích thước mảng thực tế về 0
        this.size = 0;
    }
}
