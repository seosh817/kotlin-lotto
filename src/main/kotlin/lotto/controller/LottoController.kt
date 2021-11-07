package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoGeneratorImpl
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.OutputView

object LottoController {

    fun start() {
        val money = Money.of(InputView.getMoney())
        val lottoGenerator: LottoGenerator = LottoGeneratorImpl(money)
        val lottos = Lottos.of(lottoGenerator)
        OutputView.showLottos(lottos)
        val winningLotto = Lotto.of(InputView.inputWinningNumbers())
        val lottoResult = lottos.match(winningLotto)
        OutputView.printOverview(lottoResult)
        OutputView.printProfitPercent(lottoResult, money)
    }
}
