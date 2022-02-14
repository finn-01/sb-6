


> Written with [StackEdit](https://stackedit.io/).
# @Configuration và @Bean
 - `@Configuration` là một Annotation đánh dấu trên một `Class` cho phép **Spring Boot** biết được đây là nơi định nghĩa ra các _Bean_.
- `@Bean` là một Annotation được đánh dấu trên các `method` cho phép **Spring Boot** biết được đây là _Bean_ và sẽ thực hiện đưa _Bean_ này vào `Context`.
- `@Bean` sẽ nằm trong các class có đánh dấu `@Configuration`.

Đằng sau chương trình, **Spring Boot** lần đầu khởi chạy, ngoài việc đi tìm các `@Component` thì nó còn làm một nhiệm vụ nữa là tìm các class `@Configuration`.
1.  Đi tìm class có đánh dấu `@Configuration`
2.  Tạo ra đối tượng từ class có đánh dấu `@Configuration`
3.  tìm các method có đánh dấu `@Bean` trong đối tượng vừa tạo
4.  Thực hiện gọi các method có đánh dấu `@Bean` để lấy ra các _Bean_ và đưa vào `Context.

Ngoài ra, về bản chất, `@Configuration` cũng là `@Component`. Nó chỉ khác ở ý nghĩa sử dụng. (Giống với việc class được đánh dấu `@Service` chỉ nên phục vụ logic vậy).

### **Có ý nghĩa gì?**

Nhiều bạn sẽ tự hỏi rằng `@Configuration` và `@Bean` sẽ có ý nghĩa gì khi chúng ta đã có `@Component`? Sao không đánh dấu `SimpleBean` là `@Component` cho nhanh?

Các bạn thắc mắc rất đúng, và việc sử dụng `@Component` cũng hoàn toàn ổn.

Thông thường thì các class được đánh dấu `@Component` đều có thể tạo tự động và inject tự động được.

Tuy nhiên trong thực tế, nếu một `Bean` có quá nhiều logic để khởi tạo và cấu hình, thì chúng ta sẽ sử dụng `@Configuration` và `@Bean` để tự tay tạo ra `Bean`. Việc tự tay tạo ra `Bean` như này có thể hiểu phần nào là chúng ta đang _config_ cho chương trình.

### **@Bean có tham số**

Nếu method được đánh dấu bởi `@Bean` có tham số truyền vào, thì **Spring Boot** sẽ tự inject các Bean đã có trong `Context` vào làm tham số.

### **Thực tế**

Trong thực tế, việc sử dụng `@Configuration` là hết sức cần thiết, và nó đóng vai trò là nơi cấu hình cho toàn bộ ứng dụng của bạn. Một Ứng dụng sẽ có nhiều class chứa `@Configuration` và mỗi class sẽ đảm nhận cấu hình một bộ phận gì đó trong ứng dụng.