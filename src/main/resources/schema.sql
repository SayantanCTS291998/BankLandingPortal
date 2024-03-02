create table Customer_Master(
	cust_id varchar(50) primary key,
	birth_date date,
	monthly_salary int
);
create table Loan_Application(
	loan_appid varchar(50),
	cust_id varchar(50),
	loan_amt int,
	no_of_years int,
	purpose varchar(50),
	app_status varchar(50),
	type_of_loan varchar(50),
	loan_app_date date,
	status varchar(50),
	primary key(loan_appid)
);

create table Credit_Risk(
	cr_id long primary key,
	loan_app_id varchar(50),
	credit_score int,
	emi int,
	basic_check enum('pass','fail','pending')
);
	
 