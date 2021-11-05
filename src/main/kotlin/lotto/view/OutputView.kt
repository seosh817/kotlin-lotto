package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.Rank

object OutputView {

    private const val COMMA = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"
    private const val LOTTO_RESULT = "당첨 통계"
    private const val DASH = "---------"

    fun showLottos(lottos: Lottos) {
        val output = buildString {
            append(lottos.lottos.count()).append("개를 구매했습니다.")
            append(System.lineSeparator())
            lottos.lottos.forEach {
                append(printLottoNumbers(it))
                append(System.lineSeparator())
            }
        }
        println(output)
    }

    fun printLottoNumbers(lotto: Lotto): String {
        return lotto.sortedNumbers.joinToString(
            separator = COMMA,
            prefix = PREFIX,
            postfix = POSTFIX
        ) { it.number.toString() }
    }

    fun printOverview(lottoResult: LottoResult) {
        println()
        println(LOTTO_RESULT)
        println(DASH)
        val overView = buildString {
            Rank.values()
                .filter {
                    it != Rank.MISS
                }
                .forEach {
                    append("${it.matchCount}개 일치 (${it.prize}원)- ${lottoResult.result[it] ?: 0}개")
                    append(System.lineSeparator())
                }
        }
        println(overView)
    }

    fun printProfitPercent(lottoResult: LottoResult, money: Money) {
        println("총 수익률은 ${lottoResult.getProfit(money)}입니다.")
    }
}
