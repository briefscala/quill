package io.getquill.monad

import scala.concurrent.ExecutionContext
import scala.util.Failure
import scala.util.Try

class ScalaFutureIOMonadSpec extends IOMonadSpec {

  override val ctx = io.getquill.testAsyncContext
  import ctx._

  override def eval[T](io: IO[T, _]) = {

    // hack to avoid Await.result since scala.js doesn't support it
    implicit val immediateEC = new ExecutionContext {
      def execute(runnable: Runnable) = runnable.run()
      def reportFailure(cause: Throwable) = ()
    }

    var res: Try[T] = Failure(new IllegalStateException())
    ctx.performIO(io.liftToTry).map(res = _)
    res.get
  }
}
