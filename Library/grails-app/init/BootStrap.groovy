import com.Library.*
class BootStrap {
    def init = { servletContext ->

	def Librarian1=new Librarian(name:'Ben Baller',
				email:'BB@library.com',
				userName:'BBaller',
				password:'balling',
				telephone:'07945642013').save()

	def Librarian2=new Librarian(name:'Will Wrap',
				email:'WW@library.com',
				userName:'WWrap',
				password:'bwrap',
				telephone:'07945613420').save()

	def Librarian3=new Librarian(name:'Fred Fat',
				email:'FF@library.com',
				userName:'FFat',
				password:'FredF',
				telephone:'07895246307').save()

	def Library1=new Library(location:'Sheffield',
				openingHours:'24hrs',
				book:'IT for Dummies',
				student:'Scott Daniels',
				librarian:'Ben Baller').save()

	def Library2=new Library(location:'Birmingham',
				openingHours:'24hrs',
				book:'Media for Dummies',
				student:'Lee Leaf',
				librarian:'Will Wrap').save()

	def Library3=new Library(location:'London',
				openingHours:'24hrs',
				book:'English for Dummies',
				student:'Peter Plant',
				librarian:'Fred Fat').save()

	def Book1=new Book(title:'IT for Dumbies',
				author:'Bill Gates',
				isbn:'9780470926901',
				dateBorrowed:new Date('01/01/16'),
				returnDate:new Date('14/01/16'),
				student:'Scott Daniels').save()

	def Book2=new Book(title:'Media for Dumbies',
				author:'John Warnock',
				isbn:'9780470289341',
				dateBorrowed:new Date('01/01/16'),
				returnDate:new Date('14/01/16'),
				student:'Lee Leaf').save()

	def Book3=new Book(title:'English for Dumbies',
				author:'Adam English',
				isbn:'9458214868514',
				dateBorrowed:new Date('01/01/16'),
				returnDate:new Date('14/01/16'),
				student:'Peter Plant').save()

	def Student1=new Student(name:'Scott Daniels',
				email:'SD@library.com',
				studentid:'A1005975',
				course:'Computing').save()

	def Student2=new Student(name:'Lee Leaf',
				email:'LL@library.com',
				studentid:'A1006452',
				course:'Media').save()

	def Student3=new Student(name:'Peter Plant',
				email:'PP@library.com',
				studentid:'A1002134',
				course:'English').save()

	def Course1=new Course(title:'Computing',
				code:'1978',
				tutor:'Bill Blue',
				department:'Information Technology',
				description:'n/a').save()

	def Course2=new Course(title:'Media',
				code:'4621',
				tutor:'Dan Scam',
				department:'Media',
				description:'n/a').save()

	def Course3=new Course(title:'English',
				code:'4316',
				tutor:'Adam Maddan',
				department:'English',
				description:'n/a').save()
	
    }
    def destroy = {
    }
}
