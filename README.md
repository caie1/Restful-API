# restful_api_student_course_database

### Develop api for University (students + courses)
One student can enroll in many courses.
One course can have many students.

### Tables/Models
Student(id(pk), name)  \
Course (id(pk), name)  \
Student_course(id(pk), s_id(fk), c_id(fk))  \

### Design restful api
1. create student      \
   url:/students \
   http method: POST \
   Request body{          \
      "name" : "dsfsdf"         \
   }            \
   
2. Show all students       \
   url:/students \
   http method: GET \
   
3. retrieve student by id      \
   url:/students/{id} \
   http method: GET \
   
4. update student    \
   url:/students/updatestudent \
   http method: PUT \
   Request body{          \
      "id" : 1,
      "name" : "dsfsdf"         \
   }            \
5. delete student       \
   url:/students/{id} \
   http method: DELETE \
   
6. create copurse      \
   url:/courses \
   http method: POST \
   Request body{          \
      "name" : "dsfsdf"         \
   }            \
   
2. Show all courses       \
   url:/courses  \
   http method: GET \
   
3. retrieve course by id      \
   url:/courses /{id} \
   http method: GET \
   
4. update course     \
   url:/courses/updatecourse    \
   http method: PUT \
   Request body{          \
      "id" : 1,
      "name" : "dsfsdf"         \
   }            \
5. delete courses        \
   url:/courses/{id} \
   http method: DELETE \
