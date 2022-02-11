# restful_api_student_course_database

## Develop api for University (students + courses)
One student can enroll in many courses.
One course can have many students.
Therefore, it is a many-to-many relationship.

### Tables/Models
Student(id(pk), name)
Course (id(pk), name)
Student_course(id(pk), s_id(fk), c_id(fk))

### Design restful api
1. url:/students \
   http method: POST \
   add student \

url:/courses
2. add student
3. add course
4. get all students
5. get all courses
6. get student by ID
7. get courses by ID
8. update student
9. update course
10. delete student 
11. delete course
