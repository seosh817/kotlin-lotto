package lotto.domain

class LottoNumberGeneratorImpl : LottoNumberGenerator {

    override fun generateLottoNumber(): List<LottoNumber> {
        val numbers = LottoNumber.LOTTO_NUMBERS
        val shuffledNumbers = numbers.values.shuffled()
        return shuffledNumbers.take(Lotto.SIZE)
    }
}
