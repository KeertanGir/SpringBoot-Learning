INSERT INTO companies
(name, description, company_site)
VALUES
    (
        'Systems Limited',
        'Software development and IT consulting company.',
        'https://www.systemsltd.com'
    ),
    (
        'Techlogix',
        'Technology consulting and software solutions company.',
        'https://www.techlogix.com'
    ),
    (
        'Contour Software',
        'Software development company providing enterprise solutions.',
        'https://www.contour-software.com'
    );

INSERT INTO users
(full_name, email, password, role, created_at)
VALUES
    (
        'Ahmed Khan',
        'ahmed.recruiter@example.com',
        'password123',
        'RECRUITER',
        CURRENT_TIMESTAMP
    ),
    (
        'Sara Ali',
        'sara.recruiter@example.com',
        'password123',
        'RECRUITER',
        CURRENT_TIMESTAMP
    ),
    (
        'Ali Raza',
        'ali.candidate@example.com',
        'password123',
        'CANDIDATE',
        CURRENT_TIMESTAMP
    ),
    (
        'Fatima Noor',
        'fatima.candidate@example.com',
        'password123',
        'CANDIDATE',
        CURRENT_TIMESTAMP
    ),
    (
        'Hamza Ahmed',
        'hamza.candidate@example.com',
        'password123',
        'CANDIDATE',
        CURRENT_TIMESTAMP
    );

SET @systems_company_id = (
    SELECT id
    FROM companies
    WHERE name = 'Systems Limited'
    LIMIT 1
);

SET @techlogix_company_id = (
    SELECT id
    FROM companies
    WHERE name = 'Techlogix'
    LIMIT 1
);

SET @contour_company_id = (
    SELECT id
    FROM companies
    WHERE name = 'Contour Software'
    LIMIT 1
);

SET @ahmed_recruiter_id = (
    SELECT id
    FROM users
    WHERE email = 'ahmed.recruiter@example.com'
    LIMIT 1
);

SET @sara_recruiter_id = (
    SELECT id
    FROM users
    WHERE email = 'sara.recruiter@example.com'
    LIMIT 1
);

INSERT INTO `Jobs`
(
    `Job_title`,
    `Job_Description`,
    `Location`,
    `Salary_Range`,
    `Job_Type`,
    `Posted_Date`,
    `is_Active`,
    `company_Id`,
    `posted_By_id`
)
VALUES
    (
        'Java Spring Boot Developer',
        'Develop and maintain REST APIs using Java, Spring Boot, Hibernate and MySQL.',
        'Karachi',
        'PKR 120,000 - 180,000',
        'Full-time',
        CURRENT_DATE,
        1,
        @systems_company_id,
        @ahmed_recruiter_id
    ),
    (
        'Frontend React Developer',
        'Build responsive web applications using React, JavaScript, HTML and CSS.',
        'Lahore',
        'PKR 100,000 - 150,000',
        'Full-time',
        CURRENT_DATE,
        1,
        @techlogix_company_id,
        @sara_recruiter_id
    ),
    (
        'Backend Developer Intern',
        'Assist in backend application development using Java, Spring Boot and SQL.',
        'Remote',
        'PKR 40,000 - 60,000',
        'Internship',
        CURRENT_DATE,
        1,
        @contour_company_id,
        @ahmed_recruiter_id
    ),
    (
        'Database Administrator',
        'Manage MySQL databases, backups, indexing, security and query optimization.',
        'Islamabad',
        'PKR 130,000 - 200,000',
        'Full-time',
        CURRENT_DATE,
        1,
        @systems_company_id,
        @ahmed_recruiter_id
    );

SET @java_job_id = (
    SELECT id
    FROM `Jobs`
    WHERE `Job_title` = 'Java Spring Boot Developer'
    LIMIT 1
);

SET @react_job_id = (
    SELECT id
    FROM `Jobs`
    WHERE `Job_title` = 'Frontend React Developer'
    LIMIT 1
);

SET @intern_job_id = (
    SELECT id
    FROM `Jobs`
    WHERE `Job_title` = 'Backend Developer Intern'
    LIMIT 1
);

SET @database_job_id = (
    SELECT id
    FROM `Jobs`
    WHERE `Job_title` = 'Database Administrator'
    LIMIT 1
);

SET @ali_candidate_id = (
    SELECT id
    FROM users
    WHERE email = 'ali.candidate@example.com'
    LIMIT 1
);

SET @fatima_candidate_id = (
    SELECT id
    FROM users
    WHERE email = 'fatima.candidate@example.com'
    LIMIT 1
);

SET @hamza_candidate_id = (
    SELECT id
    FROM users
    WHERE email = 'hamza.candidate@example.com'
    LIMIT 1
);

INSERT INTO applications
(
    status,
    applied_date,
    resume_url,
    job_id,
    candidate_id
)
VALUES
    (
        'PENDING',
        CURRENT_TIMESTAMP,
        'https://example.com/resumes/ali-raza.pdf',
        @java_job_id,
        @ali_candidate_id
    ),
    (
        'SHORTLISTED',
        CURRENT_TIMESTAMP,
        'https://example.com/resumes/fatima-noor.pdf',
        @react_job_id,
        @fatima_candidate_id
    ),
    (
        'PENDING',
        CURRENT_TIMESTAMP,
        'https://example.com/resumes/hamza-ahmed.pdf',
        @intern_job_id,
        @hamza_candidate_id
    ),
    (
        'REJECTED',
        CURRENT_TIMESTAMP,
        'https://example.com/resumes/ali-raza.pdf',
        @database_job_id,
        @ali_candidate_id
    );