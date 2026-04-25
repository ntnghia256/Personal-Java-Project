USE db_testing_system;

-- Department table
INSERT INTO department (department_name) VALUES
('Testing'),
('Project Management'),
('Human Resources'),
('Sales'),
('Marketing'),
('Accounting'),
('Security'),
('Training'),
('Operations'),
('Development');

SELECT * FROM department;

-- Position table
INSERT INTO `position` (position_name) VALUES
('Dev'),
('Test'),
('Scrum Master'),
('PM'),
('Intern'),
('Fresher'),
('Junior'),
('Senior'),
('Director'),
('Leader');

SELECT * FROM `position`;

-- Account table
INSERT INTO `account` (email, username, full_name, department_id, position_id) VALUES
('account1@vti.com', 'user_dev1', 'Nguyễn Văn A', 1, 1), -- Dev/Development
('account2@vti.com', 'user_test1', 'Trần Thị B', 2, 2), -- Test/Testing
('account3@vti.com', 'user_pm1', 'Lê Văn C', 3, 4), -- PM/PM
('account4@vti.com', 'user_hr1', 'Phạm Thị D', 4, 9), -- HR/Director
('account5@vti.com', 'user_sale1', 'Vũ Văn E', 5, 5), -- Sales/Intern
('account6@vti.com', 'user_dev2', 'Đỗ Thị F', 1, 3), -- Scrum Master/Development
('account7@vti.com', 'user_junior', 'Hoàng Văn G', 1, 7), -- Junior/Development
('account8@vti.com', 'user_senior', 'Ngô Thị H', 2, 8), -- Senior/Testing
('account9@vti.com', 'user_fresher', 'Bùi Văn I', 9, 6), -- Fresher/Training
('account10@vti.com', 'user_security', 'Cao Thị K', 8, 10); -- Leader/Security

INSERT INTO `account` (email, username, full_name, department_id, position_id) VALUES
('acc11@vti.com', 'user_acc11', 'Nguyễn Thị L', 1, 1), -- Dev/Development
('acc12@vti.com', 'user_acc12', 'Trần Văn M', 2, 2), -- Test/Testing
('acc13@vti.com', 'user_acc13', 'Lê Thị N', 3, 4), -- PM/PM
('acc14@vti.com', 'user_acc14', 'Phạm Văn O', 4, 9), -- HR/Director
('acc15@vti.com', 'user_acc15', 'Vũ Thị P', 5, 5), -- Sales/Intern
('acc16@vti.com', 'user_acc16', 'Đỗ Văn Q', 1, 3), -- Scrum Master/Development
('acc17@vti.com', 'user_acc17', 'Hoàng Thị R', 1, 7), -- Junior/Development
('acc18@vti.com', 'user_acc18', 'Ngô Văn S', 2, 8), -- Senior/Testing
('acc19@vti.com', 'user_acc19', 'Bùi Thị T', 9, 6), -- Fresher/Training
('acc20@vti.com', 'user_acc20', 'Cao Văn U', 8, 10); -- Leader/Security

SELECT * FROM `account`;

-- Group table
INSERT INTO `group` (group_name, creator_id) VALUES
('Fresher Class 2025', 9),
('Project Alpha Team', 1),
('Scrum Team 1', 6),
('PM Training Group', 3),
('HR Club', 4),
('Sales Target Q4', 5),
('Internal Security', 10),
('Senior Developers', 7),
('Junior Testers', 8),
('Marketing Campaign', 4);

SELECT * FROM `group`;

-- Group accounts
INSERT INTO group_account (group_id, account_id) VALUES
(1, 9), -- Fresher tham gia Fresher Class
(2, 1), -- Dev tham gia Project Alpha
(3, 6), -- Scrum Master tham gia Scrum Team 1
(4, 3), -- PM tham gia PM Training
(5, 4), -- HR tham gia HR Club
(6, 5), -- Sales tham gia Sales Target
(7, 10), -- Security tham gia Internal Security
(8, 7), -- Junior tham gia Senior Developers (để học hỏi)
(9, 8), -- Senior tham gia Junior Testers (để hướng dẫn)
(10, 2); -- Test tham gia Marketing Campaign (để kiểm thử)

SELECT * FROM group_account;

-- 1. TYPE QUESTION (Đã có 10 bản ghi trong dữ liệu cung cấp)
INSERT INTO type_question (type_name) VALUES
('Essay'), -- ID 1
('Multiple-Choice'), -- ID 2
('Multiple-Choice'), -- ID 3
('Essay'), -- ID 4
('Multiple-Choice'), -- ID 5
('Essay'), -- ID 6
('Multiple-Choice'), -- ID 7
('Essay'), -- ID 8
('Multiple-Choice'), -- ID 9
('Essay'); -- ID 10

select * from type_question;

-- 2. CATEGORY QUESTION (Đã có 10 bản ghi trong dữ liệu cung cấp)
INSERT INTO category_question (category_name) VALUES
('SQL'),              -- ID 1
('Java'),             -- ID 2
('C#'),               -- ID 3
('Soft Skills'),      -- ID 4
('Project Management'),-- ID 5
('Security'),         -- ID 6
('Testing Basic'),    -- ID 7
('Scrum'),            -- ID 8
('Network'),          -- ID 9
('Data Structure');   -- ID 10

select * from category_question;

-- 3. QUESTION (10 bản ghi)
INSERT INTO question (content, category_id, type_id, creator_id) VALUES
('Lệnh nào dùng để thêm dữ liệu vào bảng?', 1, 2, 1),      -- ID 1: SQL/MC/Creator 1
('Giải thích khái niệm "Primary Key".', 1, 1, 1),          -- ID 2: SQL/Essay/Creator 1
('Phương thức nào được dùng để tạo một Thread trong Java?', 2, 2, 7), -- ID 3: Java/MC/Creator 7
('Sự khác biệt giữa Class và Object trong C# là gì?', 3, 1, 7),      -- ID 4: C#/Essay/Creator 7
('Mô tả tầm quan trọng của Communication Skill.', 4, 1, 4), -- ID 5: Soft Skills/Essay/Creator 4
('Đâu là 5 giai đoạn phát triển nhóm (Tuckman)?', 5, 2, 3), -- ID 6: PM/MC/Creator 3
('SQL Injection hoạt động như thế nào?', 6, 1, 10),        -- ID 7: Security/Essay/Creator 10
('Giải thích khái niệm "Test Case".', 7, 1, 2),            -- ID 8: Testing/Essay/Creator 2
('Daily Scrum kéo dài tối đa bao nhiêu phút?', 8, 2, 6),   -- ID 9: Scrum/MC/Creator 6
('Địa chỉ IP có bao nhiêu bit?', 9, 2, 10);                -- ID 10: Network/MC/Creator 10

select * from category_question;

-- 4. ANSWER (10 bản ghi)
INSERT INTO answer (content, question_id, is_correct) VALUES
('INSERT INTO', 1, 1),         -- Q1: Đúng
('UPDATE', 1, 0),              -- Q1: Sai
('Thực thi interface Runnable', 3, 1), -- Q3: Đúng (MC - Nhiều đáp án đúng)
('Kế thừa class Thread', 3, 1),    -- Q3: Đúng
('Khả năng làm việc nhóm là quan trọng nhất', 4, 0), -- Q4: Sai (Essay)
('Forming, Storming, Norming, Performing, Adjourning', 6, 1), -- Q6: Đúng
('Planning, Doing, Checking, Acting', 6, 0),           -- Q6: Sai
('15 phút', 9, 1),             -- Q9: Đúng
('30 phút', 9, 0),             -- Q9: Sai
('32 bit', 10, 1);             -- Q10: Đúng

select * from answer;


-- 5. EXAM (10 bản ghi)
INSERT INTO exam (`code`, title, category_id, duration, creator_id) VALUES
('E_SQL_01', 'Bài kiểm tra SQL cơ bản', 1, 60, 1),     -- ID 1
('E_JAVA_01', 'Bài kiểm tra Java cho Fresher', 2, 90, 7),-- ID 2
('E_PM_01', 'Quy trình quản lý dự án', 5, 30, 3),      -- ID 3
('E_TEST_01', 'Kiểm thử phần mềm cơ bản', 7, 60, 2),   -- ID 4
('E_SS_01', 'Bài kiểm tra Soft Skills', 4, 45, 4),     -- ID 5
('E_SCRUM_01', 'Đánh giá kiến thức Scrum', 8, 30, 6),  -- ID 6
('E_CSHARP_01', 'Lập trình C# cơ bản', 3, 90, 7),      -- ID 7
('E_NET_01', 'Kiến thức mạng căn bản', 9, 60, 10),     -- ID 8
('E_DS_01', 'Cấu trúc dữ liệu', 10, 90, 1),            -- ID 9
('E_SEC_01', 'An ninh thông tin', 6, 60, 10);          -- ID 10

select * from exam;

-- 6. EXAM QUESTION (20 bản ghi, sử dụng exam_id từ 1-10 và question_id từ 1-10)
INSERT INTO exam_question (exam_id, question_id) VALUES
(1, 1), (1, 2), -- SQL Exam 1 có Q1, Q2
(2, 3), (2, 4), -- Java Exam 2 có Q3, Q4
(3, 5), (3, 6), -- PM Exam 3 có Q5, Q6
(4, 7), (4, 8), -- Test Exam 4 có Q7, Q8
(5, 9), (5, 10),-- Soft Skill Exam 5 có Q9, Q10
(6, 1), (6, 3), -- Scrum Exam 6 có Q1, Q3
(7, 2), (7, 4), -- C# Exam 7 có Q2, Q4
(8, 5), (8, 7), -- Net Exam 8 có Q5, Q7
(9, 6), (9, 8), -- DS Exam 9 có Q6, Q8
(10, 9), (10, 10); -- Security Exam 10 có Q9, Q10

select * from exam_question;