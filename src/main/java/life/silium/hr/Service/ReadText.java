package life.silium.hr.Service;

import jakarta.transaction.Transactional;
import life.silium.hr.Database.UserRepository;
import life.silium.hr.Database.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ReadText {
    public void read_text() {
        String filePath = "user.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;


            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String gender = data[3].trim();
                    int salary = Integer.parseInt(data[4].trim().replace("_", ""));

                    insertUsers(new Users(id,name,age,gender,salary));

                } catch (Exception e) {
                    // 잘못된 데이터가 있을 경우 로그 출력
                    System.err.println("Error processing line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    UserRepository userRepository;

    public void insertUsers(Users user){
        userRepository.save(user);
    }
}
