drop table enchantment;
create table enchantment(

	id int(12) primary key auto_increment,
	representId char(20),
	suitId char(20),
	name char(50),
	level int(4),
	goodslevel char(10),

	enchantmentKind char(40),
	search char(200),

	li int(9),
	min int(9),
	zhi int(9),
	ti int(9),

	wg char(40),
	yz int(11),
	xy int(11),
	xyDK int(11),
	zm int(11),
	zmDK int(11),

	mg char(40),
	mf int(11),
	hp int(11),
	wf int(11),
	yzDK int(11),

	gg double(9,5),
	hg double(9,5),
	sg double(9,5),
	ag double(9,5),

	gf double(9,5),
	hf double(9,5),
	sf double(9,5),
	af double(9,5),

	zz int(11),
	zmsh int(11),
	ydsd int(11),
	mphf int(11),


	li_ double(9,5),
	min_ double(9,5),
	zhi_ double(9,5),
	ti_ double(9,5),

	wg_ char(40),
	yz_ double(9,5),
	xy_ double(9,5),
	xyDK_ double(9,5),
	zm_ double(9,5),
	zmDK_ double(9,5),

	mg_ char(40),
	mf_ double(9,5),
	hp_ double(9,5),
	wf_ double(9,5),
	yzDK_ double(9,5),

	zz_ double(9,5),
	zmsh_ double(9,5),
	ydsd_ double(9,5),
	mphf_ double(9,5)
)engine=innodb default charset=utf8 auto_increment=1;

