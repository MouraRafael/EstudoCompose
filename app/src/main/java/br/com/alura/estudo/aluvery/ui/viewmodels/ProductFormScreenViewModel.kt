package br.com.alura.estudo.aluvery.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.alura.estudo.aluvery.dao.ProductDao
import br.com.alura.estudo.aluvery.model.Product
import br.com.alura.estudo.aluvery.ui.states.ProductFormScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenViewModel : ViewModel() {
    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<ProductFormScreenUiState> =
        MutableStateFlow(ProductFormScreenUiState())
    val uiState get() = _uiState.asStateFlow()
    val formatter = DecimalFormat("0.00")

    fun save(){
        _uiState.value.run {
            val convertedPrice = try {
                BigDecimal(price)
            } catch (e: NumberFormatException) {
                Log.e("ProductFormScreen", "ProductFormScreen: ${e.message}", e)
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = if(description.isNotBlank()) description else null
            )

            dao.save(product)
        }
    }

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
                onDescriptionChange = {
                    _uiState.value = _uiState.value.copy(
                        description = it
                    )
                }, onPriceChange = {
                    val price = try {
                        formatter.format(BigDecimal(it))
                    } catch (e: IllegalArgumentException) {
                        if (it.isBlank()) {
                            it
                        } else null
                    }

                    price?.let {
                        _uiState.value = _uiState.value.copy(
                            price = price
                        )
                    }
                }
            )

        }
    }
}