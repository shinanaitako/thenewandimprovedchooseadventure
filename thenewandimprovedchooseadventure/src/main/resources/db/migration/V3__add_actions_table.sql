CREATE TABLE IF NOT EXISTS actions (
   id INT AUTO_INCREMENT PRIMARY KEY,
   monster_id BIGINT,
   name TEXT,
   choice TEXT,
   description TEXT,
   result TEXT
);