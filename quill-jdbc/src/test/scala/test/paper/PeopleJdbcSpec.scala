//package test.paper
//
//import io.getquill._
//import io.getquill.jdbc.JdbcSource
//import test.Spec
//import test.testDB
//
//class PeopleJdbcSpec extends PeopleSpec {
//
//  override def beforeAll =
//    testDB.transaction {
//      testDB.run(queryable[Couple].delete)
//      testDB.run(queryable[Person].filter(_.age > 0).delete)
//      testDB.run(peopleInsert)(peopleEntries)
//      testDB.run(couplesInsert)(couplesEntries)
//    }
//
//  "Example 1 - differences" in {
//    testDB.transaction { testDB.run(`Ex 1 differences`) } mustEqual `Ex 1 expected result`
//  }
//
//  "Example 2 - range simple" in {
//    testDB.run(`Ex 2 rangeSimple`)(`Ex 2 param 1`, `Ex 2 param 2`) mustEqual `Ex 2 expected result`
//  }
//
//  "Examples 3 - satisfies" in {
//    testDB.run(`Ex 3 satisfies`) mustEqual `Ex 3 expected result`
//  }
//
//  "Examples 4 - satisfies" in {
//    testDB.run(`Ex 4 satisfies`) mustEqual `Ex 4 expected result`
//  }
//
//  "Example 5 - compose" in {
//    testDB.run(`Ex 5 compose`)(`Ex 5 param 1`, `Ex 5 param 2`) mustEqual `Ex 5 expected result`
//  }
//
//}
