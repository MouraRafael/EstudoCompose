package br.com.alura.estudo.aluvery.ui.states

data class ProductFormScreenUiState(
    val url: String = "",
    val name: String = "",
    val price: String = "",
    val description: String = "",
    val isShowPreview: Boolean = url.isNotBlank(),
    val onUrlChange: (String) -> Unit = {},
    val onNameChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {}
) 