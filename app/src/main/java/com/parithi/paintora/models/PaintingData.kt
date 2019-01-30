package com.parithi.paintora.models

data class PaintingData(var id : String,
                        var imageUrl : String,
                        var likeCount : Int,
                        var dislikeCount : Int,
                        var ownerName : String)