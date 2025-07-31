# School Management REST API

This is a RESTful application built using Spring Boot, Spring Data JPA, and Maven. It manages entities like Schools, Students, Teachers, Classes, and Subjects.

All core requirements are implemented.  
All API endpoints are tested and working.  
Bonus: Swagger/OpenAPI documentation is also included.  
Docker setup is written but currently facing an issue with MySQL port binding. This will be resolved, but the task is submitted on time.

---

## Table Structure and Relationships

The database includes the following tables:

- **school**: Stores school details.
- **student**: Each student belongs to a specific school.
- **teacher**: Each teacher belongs to a school.
- **class_entity**: Represents classes in a school, each mapped to one school.
- **subject**: Subjects taught in school, linked with teachers.
- **class_subject**: A join table between classes and subjects (many-to-many relationship).

### Relationships:

- A **School** can have many **Students**, **Teachers**, and **Classes**.
- A **Student** belongs to one **School**.
- A **Teacher** belongs to one **School** and can teach multiple **Subjects**.
- A **Class** is associated with one **School** and can have multiple **Subjects** through the `class_subject` table.
- A **Subject** can be linked to multiple **Classes** through `class_subject`.

---

## Database Diagram

The image below shows the database tables and their relationships:

![Table Structure](images/db_img1.png)
![Table Structure](images/db_img2.png)
![Table Structure](images/db_img3.png)
![Table Structure](images/db_img4.png)
![Table Structure](images/db_img5.png)
![Table Structure](images/db_img6.png)
![Table Structure](images/db_img7.png)



---

## Working Endpoint Test (Example)

The screenshot below shows that the `/api/schools` GET endpoint is working correctly:

![School Endpoint Test](images/test_1img.png)

All other endpoints have also been tested and are working properly.
