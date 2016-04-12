import com.Library.*
class BootStrap {
    def init = { servletContext ->

	def librarian1=new Librarian(name:'Dan',
				email:'BB@library.com',
				userName:'BBaller',
				password:'balling',
				telephone:'07945642013').save()

	def librarian2=new Librarian(name:'Garry',
				email:'WW@library.com',
				userName:'WWrap',
				password:'bwrap',
				telephone:'07945613420').save()

	def librarian3=new Librarian(name:'Ted',
				email:'FF@library.com',
				userName:'FFat',
				password:'FredF',
				telephone:'07895246307').save()

	def library1=new Library(location:'Sheffield',
				openingHours:'24hrs').save()

	def library2=new Library(location:'Birmingham',
				openingHours:'24hrs').save()

	def library3=new Library(location:'London',
				openingHours:'24hrs').save()

	def course1=new Course(title:'Computing',
				code:'1978',
				tutor:'Bill Blue',
				department:'Information Technology',
				description:'n/a').save()

	def course2=new Course(title:'Media',
				code:'4621',
				tutor:'Dan Scam',
				department:'Media',
				description:'n/a').save()

	def course3=new Course(title:'English',
				code:'4316',
				tutor:'Adam Maddan',
				department:'English',
				description:'n/a').save()

	def student1=new Student(name:'Scott',
				email:'SD@library.com',
				studentid:'A1005975',
				course:course1).save()

	def student2=new Student(name:'Lee',
				email:'LL@library.com',
				studentid:'A1006452',
				course:course2).save()

	def student3=new Student(name:'Peter',
				email:'PP@library.com',
				studentid:'A1002134',
				course:course3).save()


	def book1=new Book(title:'IT for Dumbies',
				author:'Bill Gates',
				isbn:'9780470926901',
				dateBorrowed:new Date('01/01/16'),
				returnDate:new Date('14/01/16'),
				student:'Scott').save()

	def book2=new Book(title:'Media for Dumbies',
				author:'John Warnock',
				isbn:'9780470289341',
				dateBorrowed:new Date('01/01/16'),
				returnDate:new Date('14/01/16'),
				student:'Lee').save()

	def book3=new Book(title:'English for Dumbies',
				author:'Adam English',
				isbn:'9458214868514',
				dateBorrowed:new Date('01/01/16'),
				returnDate:new Date('14/01/16'),
				student:'Peter').save()

		library1.addToLibrarians(librarian1)
		library2.addToLibrarians(librarian2)
		library3.addToLibrarians(librarian3)
		library1.addToStudents(student1)
		library2.addToStudents(student2)
		library3.addToStudents(student3)
		student1.addToBooks(book1)
		student2.addToBooks(book2)
		student3.addToBooks(book3)
		library1.addToBooks(book1)
		library2.addToBooks(book2)
		library3.addToBooks(book3)
		
    	}
    	def destroy = {
    	}
}
